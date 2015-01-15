package gov.usgs.cida;

import java.util.List;

public class ConsulRegistratorInfo {
    private String name;
    private String version;
    private List<String> tags;
    private String healthUrl;

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     * @return 
     */
    public ConsulRegistratorInfo setName(String name) {
	this.name = name;
	return this;
    }

    /**
     * @return the version
     */
    public String getVersion() {
	return version;
    }

    /**
     * @param version the version to set
     * @return 
     */
    public ConsulRegistratorInfo setVersion(String version) {
	this.version = version;
	return this;
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
	return tags;
    }

    /**
     * @param tags the tags to set
     * @return 
     */
    public ConsulRegistratorInfo setTags(List<String> tags) {
	this.tags = tags;
	return this;
    }

    /**
     * @return the healthUrl
     */
    public String getHealthUrl() {
	return healthUrl;
    }

    /**
     * @param healthUrl the healthUrl to set
     * @return 
     */
    public ConsulRegistratorInfo setHealthUrl(String healthUrl) {
	this.healthUrl = healthUrl;
	return this;
    }
}
