import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
import {Navbar, Nav,  Form, FormControl,Container,Button, Offcanvas} from 'react-bootstrap';

class NavigationBar extends React.Component {


      render(){
            return (

<Navbar bg="light" expand={false}>
      <Link to={""} className="navbar-brand">
      
      </Link>
  <Container fluid>
    <Navbar.Brand href="#">Welcome Product Creator</Navbar.Brand>
    <Navbar.Toggle aria-controls="offcanvasNavbar" />
    <Navbar.Offcanvas
      id="offcanvasNavbar"
      aria-labelledby="offcanvasNavbarLabel"
      placement="end"
    >
      <Offcanvas.Header closeButton>
        <Offcanvas.Title id="offcanvasNavbarLabel"></Offcanvas.Title>
      </Offcanvas.Header>
      <Offcanvas.Body>
        <Nav className="justify-content-end flex-grow-1 pe-3">
          <Link to={"add"} href="#action1" className="nav-link">Add Product</Link>
          <Link to={"lists"} href="#action2" className="nav-link">Product List</Link>
          <Link to={"/RAC"} href="#action2" className="nav-link">Revies And Comment</Link>
         
        </Nav>
        <Form className="d-flex">
          <FormControl
            type="search"
            placeholder="Search"
            className="me-2"
            aria-label="Search"
          />
          <Button variant="outline-success">Search</Button>
        </Form>
      </Offcanvas.Body>
    </Navbar.Offcanvas>
  </Container>
</Navbar>
            )
      }

}

export default NavigationBar;