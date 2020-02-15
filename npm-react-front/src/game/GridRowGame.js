import React, {Component} from "react";
import photo from "../gamePhoto1.jpg";
export default class GridRowGame extends Component {


    render() {
        return (
            <React.Fragment>
                <div className="col-4 mt-2 mb-2">
                        <div className="card">
                            <img className="card-img-top" src={photo} alt="Card image cap"/>
                            <div className="card-body">
                                <h5 className="card-title">{this.props.game.name}</h5>
                                <p className="card-text">{this.props.game.description}</p>
                                <p className="card-text"> {this.props.game.tags.map(tag => tag.tag + ' ')} </p>
                            </div>
                        </div>
                </div>
            </React.Fragment>
        )
    }
}