package cl.ficv.ejb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the TBL_MONEDAS database table.
 * @author sebastian.retamal
 * @since 13-04-2017
 */
@Entity
@Table(name="TBL_MONEDAS", schema = "FICV")
@NamedQueries({
@NamedQuery(name="Moneda.findAll", query="SELECT t FROM Moneda t"),
@NamedQuery(name="Moneda.find.descripcion", query="SELECT t FROM Moneda t where t.monedaDescripcion =:descripcion")
})
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_MONEDA_ID_GEN", sequenceName="SEQ_MONEDA_ID", schema = "FICV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MONEDA_ID_GEN")
	@Column(name="MONEDA_ID")
	private long monedaId;

	@Column(name="MONEDA_DESCRIPCION")
	private String monedaDescripcion;

	@Column(name="MONEDA_VALOR_EN_PESOS")
	private Long monedaValorEnPesos;

//	@Temporal(TemporalType.DATE)
	@Column(name="MONEDA_VIGENCIA_DESDE")
	private Date monedaVigenciaDesde;

//	@Temporal(TemporalType.DATE)
	@Column(name="MONEDA_VIGENCIA_HASTA")
	private Date monedaVigenciaHasta;

	public Moneda() {
	}

	public long getMonedaId() {
		return this.monedaId;
	}

	public void setMonedaId(long monedaId) {
		this.monedaId = monedaId;
	}

	public String getMonedaDescripcion() {
		return this.monedaDescripcion;
	}

	public void setMonedaDescripcion(String monedaDescripcion) {
		this.monedaDescripcion = monedaDescripcion;
	}

	public Long getMonedaValorEnPesos() {
		return this.monedaValorEnPesos;
	}

	public void setMonedaValorEnPesos(Long monedaValorEnPesos) {
		this.monedaValorEnPesos = monedaValorEnPesos;
	}

	public Date getMonedaVigenciaDesde() {
		return this.monedaVigenciaDesde;
	}

	public void setMonedaVigenciaDesde(Date monedaVigenciaDesde) {
		this.monedaVigenciaDesde = monedaVigenciaDesde;
	}

	public Date getMonedaVigenciaHasta() {
		return this.monedaVigenciaHasta;
	}

	public void setMonedaVigenciaHasta(Date monedaVigenciaHasta) {
		this.monedaVigenciaHasta = monedaVigenciaHasta;
	}

}