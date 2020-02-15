import React from 'react';
import '../App.css';
import NavbarHeader from "./NavbarHeader";
import MainBody from "./MainBody";
import NavbarFooter from "./NavbarFooter";

function App() {
  return (
    <div className="App">
        <NavbarHeader />
        <br />
        <h5 style={{textAlignVertical: "center",textAlign: "center"}}> Show us your game! </h5>
        <MainBody />
    </div>
  );
}

export default App;
