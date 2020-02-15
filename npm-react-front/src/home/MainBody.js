import React, {Component} from "react";
import $ from 'jquery';
import GridRowGame from "../game/GridRowGame";
import NavbarFooter from "./NavbarFooter";

export default class MainBody extends Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 1,
            amount: 5,

            tag: {
                id: '',
                gameId: '',
                tag: ''
            },

            game: {
                id: '',
                name: '',
                mark: '',
                description: '',
                tags: []
            },

            games: []
        };
        this.mainGrid = this.mainGrid.bind(this);
        this.SetGridSettings = this.SetGridSettings.bind(this);
    }

    SetGridSettings(property, value) {
        this.setState({[property]: value}, () => {
            this.settingsForPage();
        });

    }

    componentDidMount() {
        this.settingsForPage();
    }

    settingsForPage() {
        const these = this;
        $.ajax({
            type: "GET",
            dataType: "json",
            url: `http://localhost:8080/games/${these.state.amount}/${these.state.page}`,
            success: function (data, err) {
                if (err)
                    console.log(err);

                these.setState({
                    games: data
                });
            }
        });
    }

    mainGrid() {
        return (
            <div className="container">
                <div className="row justify-content-around">
                    {this.state.games.map(game =>
                        <GridRowGame key={game.id} game={game}/>
                    )}
                </div>
            </div>
        )
    }


    render() {
        return (
            <div>
                {this.mainGrid()}
                <NavbarFooter page={this.state.page} amount={this.state.amount} setProps={this.SetGridSettings}/>
            </div>
        )
    }
}