package pens.ac.id.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bidang {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=30)
	private String nama;

	@Override
	public String toString() {
		return nama;
	}
	
	
	
	
}
