import React, { Component } from 'react'
import axios from 'axios'
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Rating from '@mui/material/Rating';
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import Typography from '@mui/material/Typography';
import {Form} from  'react-bootstrap';

const StyledRating = styled(Rating)({
      '& .MuiRating-iconFilled': {
        color: '#ff6d75',
      },
      '& .MuiRating-iconHover': {
        color: '#ff3d47',
      },
    });

class ReviewsAndComment extends Component {
	constructor(props) {
		super(props)

		this.state = {
			
			reviews: '',
			comment: '',
                  email: ''
		}
	}

	changeHandler = e => {
		this.setState({ [e.target.name]: e.target.value })
	}

	submitHandler = e => {
		e.target.reset();
		console.log(this.state)
		axios
			.post('http://localhost:8091/reviews/', this.state)
			.then(response => {
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}

	render() {
		const {  reviews, comment, email } = this.state
		return (



                  <><Box
                        sx={{
                              '& > legend': { mt: 2 },
                        }}
                  >
                        <Typography component="legend">Heart the service</Typography>
                        <StyledRating
                              name="customized-color"
                              defaultValue={2}
                              getLabelText={(value) => `${value} Heart${value !== 1 ? 's' : ''}`}
                              precision={0.5}
                              icon={<FavoriteIcon fontSize="inherit" />}
                              emptyIcon={<FavoriteBorderIcon fontSize="inherit" />} />
                      
                 
           
    </Box>
    <Box>

    <Typography component="legend">Rate our Product</Typography>
      <Rating name="customized-10" defaultValue={2} max={10} />


    </Box>
                  <div>
                              <form onSubmit={this.submitHandler}>

                              <Form.Group className="mb-3" controlId="exampleForm.ControlInput1" >
    <Form.Label>Email address</Form.Label>
    <Form.Control 
    type="email"
    name="email"
    value={email}
    onChange={this.changeHandler} 
    autoComplete="off" />
  </Form.Group>

 <Form.Group className="mb-3" controlId="exampleForm.ControlInput1" >
    <Form.Label>Express your Rate and Product </Form.Label>
    <Form.Control  as="textarea" rows={3}
    type="text"
    name="reviews"
    value={reviews}
    onChange={this.changeHandler} 
    autoComplete="off" />
  </Form.Group>

  <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
    <Form.Label>Comment</Form.Label>
    <Form.Control as="textarea" rows={3}
    
    type="text"
    name="comment"
    value={comment}
    onChange={this.changeHandler} 
    autoComplete="off"
    />
  </Form.Group>

                                    <button type="submit">Submit</button>
                              </form>
                        </div></>
		)
	}
}

export default ReviewsAndComment