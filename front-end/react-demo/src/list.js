import { BrowserRouter as Router, Route, Link } from "react-router-dom";

class ItemList extends React.Component {
	
	componentDidMount() {
		fetch('http://myWebService/article/all')
        .then(res => res.json())
        .then((data) => {
           this.state.items = data.map((item, key) =>
			 <tr>
			 <td> 
				<Link to={`/details/${item.id}`}>Details</Link>
			</td>
			 <td>{{ item.name }}</td>
			 <td>{{ item.description }}</td>
		</tr>
	);
        })
   
  }

  componentWillUnmount() {
    this.state.items = [];
  }
  
  render() {
    return (
<h3>List</h3>
  <Router>
<table>
	{items}
</table>
 <Route path="/details/:id" render={(props) => <ItemDetails {...props} id={id} />} />
  </Router>
    );
  }
}

export default ItemList;