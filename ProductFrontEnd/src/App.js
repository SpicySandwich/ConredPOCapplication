import React from 'react';
import './App.css';
import Footer from './ProductComponent/Footer';
import 'bootstrap-css-only/css/bootstrap.min.css';
import './App.css';
import { Row,Container } from 'react-bootstrap';
import Product from './ProductComponent/Product';
import NavigationBar from './ProductComponent/NavigationBar';

import ReviewsAndComment from './ProductComponent/ReviewsAndComment';
import Tablelist from './ProductComponent/Tablelist';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {

     
  return (
    <Router>
          <NavigationBar/>
    
    <Container>
          <Row>


    

      
                  <Switch>

                        <Route path="/add" exact component={Product}/>
                        <Route path="/lists" exact component={Tablelist}/>
                        <Route path="/RAC" exact component={ReviewsAndComment}/>
                       
                  </Switch>


          
                  </Row>
    </Container>



<Footer/>

    </Router>
 

 
  );
}

export default App;
