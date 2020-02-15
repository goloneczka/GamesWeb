import React, {Component} from "react";
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownButton from "react-bootstrap/DropdownButton";


export default class NavbarFooter extends Component {

    constructor(props) {
        super(props);
        this.setAmountPerPage = this.setAmountPerPage.bind(this);
    }

    setAmountPerPage(e){
        this.props.setProps('amount', e)
    }

    render() {
        return (
            <div className="container">
                <div className="row justify-content-end">
                    <div className="col-7">
                            <ul className="pagination justify-content-end">
                                <li className="page-item disabled">
                                    <a className="page-link" href="#" tabIndex="-1">Previous</a>
                                </li>
                                <li className="page-item"><a className="page-link" href="#">1</a></li>
                                <li className="page-item"><a className="page-link" href="#">2</a></li>
                                <li className="page-item"><a className="page-link" href="#">3</a></li>
                                <li className="page-item">
                                    <a className="page-link" href="#">Next</a>
                                </li>
                            </ul>
                    </div>
                    <div className="col align-self-end">
                        <ul className="pagination justify-content-end">
                            <p className="text-lowercase"> Games per Page: </p>
                            <ButtonToolbar>
                                <DropdownButton drop={"up"} size="sm" title={this.props.amount} id={"gamesPerPage"}
                                                onSelect={this.setAmountPerPage} >
                                    <Dropdown.Item eventKey={5} >5</Dropdown.Item>
                                    <Dropdown.Item eventKey={6} >6</Dropdown.Item>
                                    <Dropdown.Item eventKey={9} >9</Dropdown.Item>
                                </DropdownButton>
                            </ButtonToolbar>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }
}