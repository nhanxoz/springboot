/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackjava.com.sbrestful.entities;
import java.math.BigInteger;
import javax.persistence.*;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Food", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "Id"),
      
    })
public class Food {
    public Food() {}
    @Id
    protected  Long Id;
    @Column(columnDefinition = "NVARCHAR(250) NOT NULL")
    protected String Name;
    protected String Alias;
    protected String Image;
    protected int OriginPrice;
    protected int PromotionPrice;
    protected int CategoryID;
    protected BigInteger CreatedDate;
    protected String CreatedBy;
    protected BigInteger UpdatedDate;
    protected String UpdatedBy;
    protected int ViewCount;
    protected int Status;
        @ManyToOne 
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Food(Long Id, String Name, String Alias, String Image, int OriginPrice, int PromotionPrice, int CategoryID, BigInteger CreatedDate, String CreatedBy, BigInteger UpdatedDate, String UpdatedBy, int ViewCount, int Status, Category category) {
        this.Id = Id;
        this.Name = Name;
        this.Alias = Alias;
        this.Image = Image;
        this.OriginPrice = OriginPrice;
        this.PromotionPrice = PromotionPrice;
        this.CategoryID = CategoryID;
        this.CreatedDate = CreatedDate;
        this.CreatedBy = CreatedBy;
        this.UpdatedDate = UpdatedDate;
        this.UpdatedBy = UpdatedBy;
        this.ViewCount = ViewCount;
        this.Status = Status;
        this.category = category;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getOriginPrice() {
        return OriginPrice;
    }

    public void setOriginPrice(int OriginPrice) {
        this.OriginPrice = OriginPrice;
    }

    public int getPromotionPrice() {
        return PromotionPrice;
    }

    public void setPromotionPrice(int PromotionPrice) {
        this.PromotionPrice = PromotionPrice;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public BigInteger getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(BigInteger CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public BigInteger getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(BigInteger UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int ViewCount) {
        this.ViewCount = ViewCount;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
}

    
