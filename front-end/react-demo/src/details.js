class ItemDetails extends React.Component {
	
	 constructor(props) {
		super(props);
		this.state = { item: {} };
		fetch('http://myWebService/article/' + this.props.match.params.props.id)
        .then(res => res.json())
        .then((data) => {
           this.state.item = data;
		}
			);
        })
	}

  
  render() {
    return (
	<div>
<h3>Dettagli prodotto: {this.state.item.name}</h3>

<div>
  <div>ID: {this.state.item.id}</div>
  <div>Name: {this.state.item.name}</div>
  <div>Description: {this.state.item.description}</div>
</div>
</div>
    );
  }
}

export default ItemDetails;