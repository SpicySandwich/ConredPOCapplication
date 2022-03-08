import React from "react";
import { MDBCol, MDBContainer, MDBRow, MDBFooter } from "mdbreact";
import 'bootstrap-css-only/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css'; 
import'bootstrap-css-only/css/bootstrap.min.css'; 
import'mdbreact/dist/css/mdb.css';


const Footer = () =>{

      return(
            

<MDBFooter color="blue" className="font-small pt-4 mt-4" >
      <MDBContainer fluid className="text-center text-md-left" >
        <MDBRow fixed="bottom">
          <MDBCol md="6">
            <h5 className="title">About us</h5>
            <p>
             
            </p>
          </MDBCol>
         
        </MDBRow>
      </MDBContainer>
      <div className="footer-copyright text-center py-3">
        <MDBContainer fluid>
      </MDBContainer>
      </div>
    </MDBFooter>
      );


}
export default Footer;