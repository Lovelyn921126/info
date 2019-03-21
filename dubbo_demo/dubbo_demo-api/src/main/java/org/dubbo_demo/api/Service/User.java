package org.dubbo_demo.api.Service;

import java.io.Serializable;

public class User implements Serializable {
 
   
    /**
	 * 
	 */
	private static final long serialVersionUID = -8838420045921069225L;


	private Long id;
 

    private String name;
 
    public User() {
    }
 
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", name='" + name + '\'' +
                ')';
    }
}