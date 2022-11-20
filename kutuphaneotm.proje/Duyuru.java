/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphanetakip;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Birnur
 */
@Entity
@Table(name = "duyuru", catalog = "kutuphanetakip", schema = "")
@NamedQueries({
    @NamedQuery(name = "Duyuru.findAll", query = "SELECT d FROM Duyuru d"),
    @NamedQuery(name = "Duyuru.findById", query = "SELECT d FROM Duyuru d WHERE d.id = :id"),
    @NamedQuery(name = "Duyuru.findByBasliklar", query = "SELECT d FROM Duyuru d WHERE d.basliklar = :basliklar")})
public class Duyuru implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "basliklar")
    private String basliklar;
    @Basic(optional = false)
    @Lob
    @Column(name = "duyurular")
    private String duyurular;

    public Duyuru() {
    }

    public Duyuru(Integer id) {
        this.id = id;
    }

    public Duyuru(Integer id, String basliklar, String duyurular) {
        this.id = id;
        this.basliklar = basliklar;
        this.duyurular = duyurular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBasliklar() {
        return basliklar;
    }

    public void setBasliklar(String basliklar) {
        String oldBasliklar = this.basliklar;
        this.basliklar = basliklar;
        changeSupport.firePropertyChange("basliklar", oldBasliklar, basliklar);
    }

    public String getDuyurular() {
        return duyurular;
    }

    public void setDuyurular(String duyurular) {
        String oldDuyurular = this.duyurular;
        this.duyurular = duyurular;
        changeSupport.firePropertyChange("duyurular", oldDuyurular, duyurular);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duyuru)) {
            return false;
        }
        Duyuru other = (Duyuru) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kutuphanetakip.Duyuru[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
