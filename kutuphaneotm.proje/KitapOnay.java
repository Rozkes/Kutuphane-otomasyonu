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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Birnur
 */
@Entity
@Table(name = "kitap_onay", catalog = "kutuphanetakip", schema = "")
@NamedQueries({
    @NamedQuery(name = "KitapOnay.findAll", query = "SELECT k FROM KitapOnay k"),
    @NamedQuery(name = "KitapOnay.findById", query = "SELECT k FROM KitapOnay k WHERE k.id = :id"),
    @NamedQuery(name = "KitapOnay.findByUid", query = "SELECT k FROM KitapOnay k WHERE k.uid = :uid"),
    @NamedQuery(name = "KitapOnay.findByKid", query = "SELECT k FROM KitapOnay k WHERE k.kid = :kid"),
    @NamedQuery(name = "KitapOnay.findByOnay", query = "SELECT k FROM KitapOnay k WHERE k.onay = :onay")})
public class KitapOnay implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "uid")
    private int uid;
    @Basic(optional = false)
    @Column(name = "kid")
    private int kid;
    @Basic(optional = false)
    @Column(name = "onay")
    private String onay;

    public KitapOnay() {
    }

    public KitapOnay(Integer id) {
        this.id = id;
    }

    public KitapOnay(Integer id, int uid, int kid, String onay) {
        this.id = id;
        this.uid = uid;
        this.kid = kid;
        this.onay = onay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        int oldUid = this.uid;
        this.uid = uid;
        changeSupport.firePropertyChange("uid", oldUid, uid);
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        int oldKid = this.kid;
        this.kid = kid;
        changeSupport.firePropertyChange("kid", oldKid, kid);
    }

    public String getOnay() {
        return onay;
    }

    public void setOnay(String onay) {
        String oldOnay = this.onay;
        this.onay = onay;
        changeSupport.firePropertyChange("onay", oldOnay, onay);
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
        if (!(object instanceof KitapOnay)) {
            return false;
        }
        KitapOnay other = (KitapOnay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kutuphanetakip.KitapOnay[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
