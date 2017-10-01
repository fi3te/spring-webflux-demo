package com.github.fi3te.spring.webflux.demo.dto;

public class UserDTO {

	private long id;

	private String name;

    public UserDTO() {
    }

    public UserDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
        return "UserDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
