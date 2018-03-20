package com.mycompany.myapp.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author admin
 *
 */
public class GetHolidayDateIn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@NotNull
	private String codePaye;
	@NotBlank
	@NotNull
	private String codeVacance;
	@NotBlank
	@NotNull
	@Size(min=4, max=4)
	private String annee;
	
	/**
	 * 
	 */
	public GetHolidayDateIn() {
		super();
	}

	/**
	 * @return the codePaye
	 */
	public String getCodePaye() {
		return codePaye;
	}

	/**
	 * @param codePaye the codePaye to set
	 */
	public void setCodePaye(String codePaye) {
		this.codePaye = codePaye;
	}

	/**
	 * @return the codeVacance
	 */
	public String getCodeVacance() {
		return codeVacance;
	}

	/**
	 * @param codeVacance the codeVacance to set
	 */
	public void setCodeVacance(String codeVacance) {
		this.codeVacance = codeVacance;
	}

	/**
	 * @return the annee
	 */
	public String getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(String annee) {
		this.annee = annee;
	}

	
}
