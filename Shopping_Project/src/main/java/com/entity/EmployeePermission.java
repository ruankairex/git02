package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_permissions")
public class EmployeePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private int permissionId;

    @Column(name = "department")
    private String department;

    @Column(name = "title")
    private String title;

    @Column(name = "db_authority", unique = true, nullable = false)
    private String dbAuthority;

    @Column(name = "db_authority_description")
    private String dbAuthorityDescription;

    @Column(name = "webpage_tables")
    private String webpageTables;

    @Column(name = "webpage_details")
    private String webpageDetails;

    public EmployeePermission() {
    }

	public EmployeePermission(int permissionId, String department, String title, String dbAuthority,
			String dbAuthorityDescription, String webpageTables, String webpageDetails) {
		super();
		this.permissionId = permissionId;
		this.department = department;
		this.title = title;
		this.dbAuthority = dbAuthority;
		this.dbAuthorityDescription = dbAuthorityDescription;
		this.webpageTables = webpageTables;
		this.webpageDetails = webpageDetails;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDbAuthority() {
		return dbAuthority;
	}

	public void setDbAuthority(String dbAuthority) {
		this.dbAuthority = dbAuthority;
	}

	public String getDbAuthorityDescription() {
		return dbAuthorityDescription;
	}

	public void setDbAuthorityDescription(String dbAuthorityDescription) {
		this.dbAuthorityDescription = dbAuthorityDescription;
	}

	public String getWebpageTables() {
		return webpageTables;
	}

	public void setWebpageTables(String webpageTables) {
		this.webpageTables = webpageTables;
	}

	public String getWebpageDetails() {
		return webpageDetails;
	}

	public void setWebpageDetails(String webpageDetails) {
		this.webpageDetails = webpageDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeePermission [permissionId=");
		builder.append(permissionId);
		builder.append(", department=");
		builder.append(department);
		builder.append(", title=");
		builder.append(title);
		builder.append(", dbAuthority=");
		builder.append(dbAuthority);
		builder.append(", dbAuthorityDescription=");
		builder.append(dbAuthorityDescription);
		builder.append(", webpageTables=");
		builder.append(webpageTables);
		builder.append(", webpageDetails=");
		builder.append(webpageDetails);
		builder.append("]");
		return builder.toString();
	}

   
}