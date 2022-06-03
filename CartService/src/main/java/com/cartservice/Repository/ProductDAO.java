package com.cartservice.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cartservice.Model.ProductEntity;

@Mapper
public interface ProductDAO {
	
	@Select("select * from tb_product")
    public  List <ProductEntity> findAll();

	
	@Insert("INSERT INTO tb_product(purchase_item,  productname, productbrand,productprice,productdescription,productquantity,productexpirationdate) " +
		      " VALUES (#{purchase_item}, #{productname}, #{productbrand}, #{productprice}, #{productdescription}, #{productquantity}, #{productexpirationdate} )")
@Options(useGeneratedKeys = true, keyColumn = "purchase_item", keyProperty = "purchase_item")
	public int insert(ProductEntity  productEntity);
	
	@Delete("DELETE FROM tb_product WHERE purchase_item = #{purchase_item}")
	public void deleteById(Integer purchase_item);
	
	@Select("SELECT * FROM tb_product  WHERE  purchase_item = #{purchase_item}")
	 public ProductEntity findById(Integer purchase_item);
	
	 @Update("Update tb_product set "
	 		+ "productname=#{productname}, " +
		        "productbrand=#{productbrand},"
		        + " productprice=#{productprice},"
		        + " productdescription=#{productdescription},"
		        + " productquantity=#{productquantity},"
		        + " productexpirationdate=#{productexpirationdate}"
		        + "where purchase_item = #{purchase_item} ")
		   void update(ProductEntity  productEntity);

	 
	 @Select("SELECT EXISTS(SELECT 1 FROM tb_product WHERE purchase_item = #{purchase_item})")
	 boolean ifIDExist(Integer purchase_item);
}
