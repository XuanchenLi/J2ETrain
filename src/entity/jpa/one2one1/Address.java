package entity.jpa.one2one1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "address_o2o1")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	private String detail;
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String province;
	private String city;
	private String zip;

	public Address() {
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}