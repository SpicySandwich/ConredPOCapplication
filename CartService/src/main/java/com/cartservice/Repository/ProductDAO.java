package com.cartservice.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cartservice.Model.Client;
import com.cartservice.Model.ProductEntity;
import com.grpcserver.product.ProductServer.Product;

@Mapper
public interface ProductDAO {
	
	@Select("select * from tb_product")
	@Results({
		@Result(property = "purchase_item", column = "purchase_item"),
	    @Result(property = "productname", column = "productname"),
		@Result(property = "productbrand", column = "productbrand"),
		@Result(property = "productprice", column = "productprice"),
		@Result(property = "productdescription", column = "productdescription"),
		@Result(property = "productquantity", column = "productquantity"),
		@Result(property = "productexpirationdate", column = "productexpirationdate")
	})
    public  List <ProductEntity> findAll();
	
	@Select("select * from tb_product")
    public  List <Product> findAll2();
	
	@Insert("INSERT INTO tb_product(purchase_item,  productname, productbrand,productprice,productdescription,productquantity,productexpirationdate) " +
		      " VALUES (#{purchase_item}, #{productname}, #{productbrand}, #{productprice}, #{productdescription}, #{productquantity}, #{productexpirationdate} )")
@Options(useGeneratedKeys = true, keyColumn = "purchase_item", keyProperty = "purchase_item")
	public int insert(ProductEntity  productEntity);
	
	@Delete("DELETE FROM tb_product WHERE purchase_item = #{purchase_item}")
	public ProductEntity deleteById(Integer client_guest_id);
	
	@Select("SELECT * FROM tb_product  WHERE purchase_item = #{purchase_item}")
	 public ProductEntity findById(Integer client_guest_id);
	
	 @Update("Update tb_product set productname=#{productname}, " +
		        "productbrand=#{productbrand}, productprice=#{productprice}, productdescription=#{productdescription}, productquantity=#{productquantity}, productexpirationdate=#{productexpirationdate}"
		        + "where purchase_item = #{purchase_item} ")
		   void update(ProductEntity  productEntity);

}
