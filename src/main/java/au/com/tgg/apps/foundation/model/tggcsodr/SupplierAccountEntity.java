package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "supplier_account")
@DynamicUpdate
@SuppressWarnings("ALL")
public class SupplierAccountEntity {

    @Id
    @Column(name = "supplier_account_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_supplier_account_id")
    @SequenceGenerator(name="seq_supplier_account_id", sequenceName="seq_supplier_account_id",allocationSize=1)
    private BigInteger supplierAccountId;

    @Basic
    @Column(name = "account_number")
    private String accountNumber;   //RMS PK

    @Basic
    @Column(name = "account_name")
    private String accountName;

    @Basic
    @Column(name = "pp_deal_parity_ind")
    private String ppDealParityInd;

    @Basic
    @Column(name = "pp_age_of_stock")
    private BigInteger ppAgeOfStock;

    @Basic
    @Column(name = "sup_ldg_code")
    private String supLdgCode;

    @Basic
    @Column(name = "sup_acc_active_ind")
    private String supAccActiveInd;

    @Basic
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "created_user")
    private String createdUser;

    @Basic
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @Basic
    @Column(name = "last_update_user")
    private String lastUpdateUser;

    @Basic
    @Column(name = "country_code")
    private String countryCode;

    @Basic
    @Column(name = "tgg_url")
    private String tggUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="supplierAccountEntity")
    private List<ProductEntity> productEntityList;

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    public BigInteger getSupplierAccountId() {
        return supplierAccountId;
    }

    public void setSupplierAccountId(BigInteger supplierAccountId) {
        this.supplierAccountId = supplierAccountId;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public String getPpDealParityInd() {
        return ppDealParityInd;
    }

    public void setPpDealParityInd(String ppDealParityInd) {
        this.ppDealParityInd = ppDealParityInd;
    }


    public BigInteger getPpAgeOfStock() {
        return ppAgeOfStock;
    }

    public void setPpAgeOfStock(BigInteger ppAgeOfStock) {
        this.ppAgeOfStock = ppAgeOfStock;
    }


    public String getSupLdgCode() {
        return supLdgCode;
    }

    public void setSupLdgCode(String supLdgCode) {
        this.supLdgCode = supLdgCode;
    }


    public String getSupAccActiveInd() {
        return supAccActiveInd;
    }

    public void setSupAccActiveInd(String supAccActiveInd) {
        this.supAccActiveInd = supAccActiveInd;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }


    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public String getTggUrl() {
        return tggUrl;
    }

    public void setTggUrl(String tggUrl) {
        this.tggUrl = tggUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierAccountEntity that = (SupplierAccountEntity) o;
        return Objects.equals(supplierAccountId, that.supplierAccountId) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(ppDealParityInd, that.ppDealParityInd) &&
                Objects.equals(ppAgeOfStock, that.ppAgeOfStock) &&
                Objects.equals(supLdgCode, that.supLdgCode) &&
                Objects.equals(supAccActiveInd, that.supAccActiveInd) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(tggUrl, that.tggUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierAccountId, accountNumber, accountName, ppDealParityInd, ppAgeOfStock, supLdgCode, supAccActiveInd, createdDate, createdUser, lastUpdateDate, lastUpdateUser, countryCode, tggUrl);
    }
}
