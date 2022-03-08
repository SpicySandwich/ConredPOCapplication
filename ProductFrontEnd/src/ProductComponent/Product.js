import * as React from 'react';

import axios from "axios";
import'bootstrap-css-only/css/bootstrap.min.css'; 
import 'bootstrap/dist/css/bootstrap.min.css';
import {Form,Button} from  'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css'



class Product extends React.Component {


       
  constructor(props){
    super(props);
    this.state ={
      product:[],
      productid:0,
      productname:'',
      productbrand:'',
      productprice:'',
      productdescription:'',
      productquantity:'',
      productcurrentdate:'',
      productexpirationdate:''
    }

    
  

  }
 

  
  componentDidMount(){
    axios.get("http://localhost:8091/product/productlist")
    .then((res)=>{
      this.setState({
        product:res.data,
        productid:0,
      productname:'',
      productbrand:'',
      productprice:'',
      productdescription:'',
      productquantity:'',
      productcurrentdate:'',
      productexpirationdate:''
      })
    })
  }
  submit(event,productid){
    event.preventDefault();
    if(productid === 0){
      axios.post("http://localhost:8091/product/addproduct",{
            productname:this.state.productname,
            productbrand:this.state.productbrand,
            productprice:this.state.productprice,
            productdescription:this.state.productdescription,
            productquantity:this.state.productquantity,
            productcurrentdate:this.state.productcurrentdate,
            productexpirationdate:this.state.productexpirationdate
      })
      .then((res)=>{
        this.componentDidMount();
      })
    }else{
      axios.put("http://localhost:8091/updateproduct",{
            productid:this.state.productid,
            productname:this.state.productname,
            productbrand:this.state.productbrand,
            productprice:this.state.productprice,
            productdescription:this.state.productdescription,
            productquantity:this.state.productquantity,
            productcurrentdate:this.state.productcurrentdate,
            productexpirationdate:this.state.productexpirationdate
      }).then(()=>{
        this.componentDidMount();
      })

    }

  }
 
 
  render(){
  return (


      
    <div className="container" >




          
          <Form onSubmit={(e)=>this.submit(e,this.state.productid)}>

  <Form.Group className="mb-3" >
        
    <Form.Label>Product name</Form.Label>
    <Form.Control type="text" placeholder="Enter Product Name" 
    onChange={(e)=>this.setState({productname:e.target.value})} value={this.state.productname}/>
    <Form.Text className="text-muted">
      We'll never share your email with anyone else.
    </Form.Text>
  </Form.Group>

  <Form.Group className="mb-3" >
        
        <Form.Label>Produc Brand</Form.Label>
        <Form.Control type="text" placeholder="Enter Produc Brand" 
       onChange={(e)=>this.setState({productbrand:e.target.value})} value={this.state.productbrand} />
       <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>


      <Form.Group className="mb-3" >
        
        <Form.Label>Product Price</Form.Label>
        <Form.Control type="number" placeholder="Enter Product Price" 
         onChange={(e)=>this.setState({productprice:e.target.value})} value={this.state.productprice} />
      <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" >
        
        <Form.Label>Product Description</Form.Label>
        <Form.Control type="text" placeholder="Enter Product Description" 
         onChange={(e)=>this.setState({productdescription:e.target.value})} value={this.state.productdescription} />
      <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" >
        
        <Form.Label>Product Quantity</Form.Label>
        <Form.Control type="number" placeholder="Enter Product Quantity" 
          onChange={(e)=>this.setState({productquantity:e.target.value})} value={this.state.productquantity}  />
      <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" >
        
        <Form.Label>Product Current Date</Form.Label>
        <Form.Control type="date" placeholder="Enter Product Current Date" 
           onChange={(e)=>this.setState({productcurrentdate:e.target.value})} value={this.state.productcurrentdate}   />
      <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" >
        
        <Form.Label>Product Expiration Date</Form.Label>
        <Form.Control type="date" placeholder="Enter Product Current Date" 
          onChange={(e)=>this.setState({productexpirationdate:e.target.value})} value={this.state.productexpirationdate}  />
      <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

 
  <Button variant="primary"  class="btn waves-effect waves-light right" type="submit" name="action">
    Submit
  </Button>
</Form> 
 
    </div>

    
  );

  
  }
}

export default Product;