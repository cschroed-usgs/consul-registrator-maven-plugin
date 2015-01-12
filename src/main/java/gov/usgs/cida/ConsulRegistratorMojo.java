package gov.usgs.cida;

import com.orbitz.consul.AgentClient;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.Registration;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Registers a service with a consul agent.
 */
@Mojo( name = "register")
public class ConsulRegistratorMojo extends AbstractMojo
{
    /**
     * Note that Orbitz' consul-client assumes that the service host and the 
     * consul agent host are the same.
     */
    @Parameter(property = "consul.registrator.host")
    private String host;
    
    @Parameter(property = "consul.registrator.consulPort", defaultValue = "8500")
    private int consulPort;
    @Parameter(property = "consul.registrator.servicePort", defaultValue = "8080")
    private int servicePort;
    @Parameter(property = "consul.registrator.serviceName")
    private String serviceName;
    @Parameter(property = "consul.registrator.serviceId")
    private String serviceId = null;
    @Parameter(property = "consul.registrator.tags")
    private String[] tags;
    @Parameter(property = "consul.registrator.check.ttl")
    private String ttl;
    @Parameter(property = "consul.registrator.check.interval")
    private String interval;
    
    /**
     * Each string in this array is the trailing url fragment of everything that
     * comes after your port number. Do not specify host names, protocols, or 
     * ports in these strings.
     */
    @Parameter(property = "consul.registrator.check.contextPaths")
    private String[] urls = null;
    /**
     * If the *custom* script parameter is set, the *urls* parameter will be ignored
     */
    @Parameter(property = "consul.registrator.check.customScript")
    private String customScript = null;
    
    public void execute() throws MojoExecutionException
    {
	Consul consul = Consul.newClient(host, consulPort);
	
	AgentClient agentClient = consul.agentClient();
	Registration registration = new Registration();
	
	String myServiceId = (StringUtils.isEmpty(serviceId)) ? serviceName : serviceId;
	registration.setId(myServiceId);

	registration.setPort(servicePort);
	registration.setName(serviceName);
	registration.setTags(tags);
	
	Registration.Check check = new Registration.Check();
	check.setTtl(ttl);
	check.setInterval(interval);
	check.setScript(buildScript(customScript, urls));
	
	registration.setCheck(check);
	
	agentClient.register(registration);
    }
    protected String buildScript(String customScript, String[] urls){
	String script = null;
	if(!StringUtils.isEmpty(script)){
	    if(!ArrayUtils.isEmpty(urls)){
		getLog().warn("Both *customScript* and *urls* parameters have been set. *customScript* will be used, *urls* will be ignored.");
	    }
	    script = customScript;
	}
	else if(!ArrayUtils.isEmpty(urls)){
	    StrBuilder sb = new StrBuilder();
	    sb.append("curl ");//trailing space in string intentional
	    for(String url : urls){
		//TODO: make protocol configurable
		sb.append("http://");
		sb.append(host);
		sb.append(servicePort);
		sb.append(url);
		sb.append(' ');
	    }
	    script = sb.build();
	}
	else{
	    getLog().debug("No check defined");
	}
	return script;
    }
}