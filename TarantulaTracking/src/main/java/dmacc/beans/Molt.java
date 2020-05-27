package dmacc.beans;

import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Molt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long moltId;
	private String moltDate;
	private double newLegSpan;
	

	
	@ManyToOne (cascade= {CascadeType.REFRESH} ,fetch = FetchType.LAZY)
	//@JoinColumn(name="tID",referencedColumnName="tId")
	private Tarantula tarantula;
	
	
	
	public Molt (Tarantula t)
	{
		this.tarantula = t;

		System.out.print("***************"+ " HELLO WATS UP FROM MOLT CLASS this.tid"+ this.tarantula.getTId()+ "**********");
	}
	
	
	
	
	

}
