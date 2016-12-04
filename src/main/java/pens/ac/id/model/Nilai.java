package pens.ac.id.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by indratir on 23/11/16.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Nilai  {
    @Id
    private long kode_mk;

    @Column(length=12)
    private long nip_dosen;

    @Column(length=10)
    private long nrp;

    @Column(length=4)
    private String nilai;

    @Column(length=1)
    private String semester;

    @Column(length=4)
    private String tahun_ajaran;

    public String toString(){
        return ""+kode_mk+"\t"+nip_dosen+"\t"+nrp +"\t"+nilai;
    }
}
