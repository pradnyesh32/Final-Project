import React, { Component } from 'react';

class ColorChanger extends Component {
  constructor(props) {
    super(props);
    this.state = {
      color: 'red',
    };
  }

  componentDidMount() {
    this.intervalId = setInterval(() => {
      const colors = ['lightred', 'lightgreen', 'lightblue',"lightyellow","cyan","indigo","violet","pink"];
      const randomIndex = Math.floor(Math.random() * colors.length);
      this.setState({ color: colors[randomIndex] });
    }, 500); // Change color every second
  }

  componentWillUnmount() {
    clearInterval(this.intervalId);
  }

  render() {
    return (
      <div >
        <b style={{color:"black",fontSize:50, backgroundColor: this.state.color ,borderRadius:25,width:800,textAlign:"center",marginLeft:100}} > Welcome To Housing Society Portal!!!</b><br></br>
      </div>
    );
  }
}

export default ColorChanger;