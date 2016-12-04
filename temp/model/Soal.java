package pens.ac.id.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Soal {
	
	@Id
	@GeneratedValue
	private long id;
	

	@ManyToOne
	private Tingkat tingkat;

	@ManyToOne
	private Bidang bidang;
	
	@Column(length=50)
	private String textSoal;
	
	public String toString() {
		return bidang+" "+tingkat+" : "+textSoal;
	}
//	
//	private long bidangId;
//	private long tingkatId;
//	
	
}
