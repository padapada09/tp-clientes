package nube.tp.clientes.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "obra")
public class Obra {
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer id;

	@Column()
	public String descripcion;

	@Column()
	public Float latitud;

	@Column()
	public Float longitud;

	@Column()
	public String direccion;

	@Column()
	public Integer superficie;

	@Enumerated(EnumType.STRING)
	public TipoObra tipo;

	@Override
	public String toString() {
		return "Obra [descripcion=" + descripcion + ", id=" + id + "]";
	}
}
