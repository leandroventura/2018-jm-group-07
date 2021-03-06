package sge.categorias;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import sge.SuperClase;

@Entity
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Categoria extends SuperClase
{
	
	
	public abstract double aproximarFacturacion(double KWConsumidos);

	public abstract boolean perteneceAEstaCategoria(double valorConsumido);
}
