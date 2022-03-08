import * as React from 'react';
import { Button,Modal } from 'react-bootstrap'
import IconButton from '@mui/material/IconButton';
import Fingerprint from '@mui/icons-material/Fingerprint';
import Stack from '@mui/material/Stack';
import {Form} from  'react-bootstrap';
import DeleteIcon from '@mui/icons-material/Delete';
import axios from "axios";
import'bootstrap-css-only/css/bootstrap.min.css'; 
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css'

import Table from 'react-bootstrap/Table';





class Tablelist extends React.Component {

     
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

          

       
        
            this.showModal = this.showModal.bind(this);
    this.hideModal = this.hideModal.bind(this);
          }
          showModal = () => {
            this.setState({ show: true });
          };
        
          hideModal = () => {
            this.setState({ show: false });
          };
          handleModalShowHide() {
            this.setState({ showHide: !this.state.showHide })
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
              axios.put("http://localhost:8091/product/productupdate",{
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
          delete(productid){
            axios.delete(`http://localhost:8091/product/productdelete/${productid}`)
            .then(()=>{
              this.componentDidMount();
            })
          }
          edit(productid){
            axios.get(`http://localhost:8091/product/productview/${productid}`)
            .then((res)=>{
              console.log(res.data);
              this.setState({
                    productid:res.data.productid,
                    productname:res.data.productname,
                    productbrand:res.data.productbrand,
                    productprice:res.data.productprice,
                    productdescription:res.data.productdescription,
                    productquantity:res.data.productquantity,
                    productcurrentdate:res.data.productcurrentdate,
                    productexpirationdate:res.data.productexpirationdate
              })
            })
          }
          render(){

      

 
          return (

          <Table striped bordered hover variant="dark">
                            <thead>
                                  <tr>
                                        <th>Product Name</th>
                                        <th>Product Brand</th>
                                        <th>Product Price</th>
                                        <th>Product Description</th>
                                        <th>Product Quantity</th>
                                        <th>Product Current Date</th>
                                        <th>Product Expiration Date</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                  </tr>
                            </thead>

                            <tbody>
                                  {this.state.product.map(product => <tr key={product.productid}>
                                        <td>{product.productname} </td>

                                        <td>{product.productbrand}</td>

                                        <td>{product.productprice} </td>

                                        <td>{product.productdescription} </td>

                                        <td>{product.productquantity} </td>

                                        <td>{product.productcurrentdate} </td>

                                        <td>{product.productexpirationdate}  </td>
                                        <td>

                                        
                      
                      <Stack direction="row" spacing={1}>
      <IconButton aria-label="fingerprint" color="success" onClick={(e) => { this.edit(product.productid); this.handleModalShowHide();}} >
      <i class="material-icons"></i>
      <Fingerprint />
                </IconButton>

                
      
      
    </Stack>

    
                      <Modal show={this.state.showHide}>
                            <Modal.Header closeButton onClick={(e) => this.handleModalShowHide().edit(product.productid)}>
                                  <Modal.Title>Product Update</Modal.Title>
                            </Modal.Header>
                            <Modal.Body>

                            <Form onSubmit={(e)=>this.submit(e,this.state.productid)}>

         
                            <Form.Group className="mb-3" >
      
      <Form.Label>Product name</Form.Label>
      <Form.Control type="hidden" placeholder="Enter Product Name" 
      onChange={(e)=>this.setState({productid:e.target.value})} value={this.state.productid}/>
      <Form.Text className="text-muted">
        We'll never share your email with anyone else.
      </Form.Text>
    </Form.Group>

    

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
      <Form.Control type="text" placeholder="Enter Product Current Date"  
         onChange={(e)=>this.setState({productcurrentdate:e.target.value})} value={this.state.productcurrentdate}   />
    <Form.Text className="text-muted">
        We'll never share your email with anyone else.
      </Form.Text>
    </Form.Group>

    <Form.Group className="mb-3" >
      
      <Form.Label>Product Expiration Date</Form.Label>
      <Form.Control type="text" placeholder="Enter Product Current Date" 
        onChange={(e)=>this.setState({productexpirationdate:e.target.value})} value={this.state.productexpirationdate}  />
    <Form.Text className="text-muted">
        We'll never share your email with anyone else.
      </Form.Text>
    </Form.Group>
    </Form>

    
                            </Modal.Body>
                            <Modal.Footer>
                                  <Button variant="secondary" onClick={() => this.handleModalShowHide()}>
                                        Close
                                  </Button>
                                  <Button variant="primary" onClick={() => this.handleModalShowHide()} class="btn waves-effect waves-light right" type="submit" name="action">
                                        Save Changes
                                  </Button>
                            </Modal.Footer>
                      </Modal>
                                        </td>
                                        <td>
                                              <Stack direction="row" alignItems="center" spacing={0}>

                                                    <IconButton aria-label="delete" size="large" onClick={(e) => this.delete(product.productid)} type="submit" name="action">
                                                          <DeleteIcon fontSize="large" color="secondary" />
                                                    </IconButton>
                                              </Stack>

                                        </td>
                                  </tr>
                                  )}

                            </tbody>
                      </Table>

         
         
         

          
          

            );
            
          
  
      }
    }

export default Tablelist;