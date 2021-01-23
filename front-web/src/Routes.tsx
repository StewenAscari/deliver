import { BrowserRouter, Switch, Route } from "react-router-dom";
import Footer from "./Footer";
import Home from "./Home";
import NavBar from "./Navbar";
import Orders from "./Orders";

function Routes(){

    return (

        <BrowserRouter>
            <NavBar />
            <Switch>
                <Route path="/orders">
                    <Orders />
                </Route>

                <Route path="/">
                    <Home />
                </Route>
            </Switch>
            
            <Footer />
        </BrowserRouter>

    )
}

export default Routes;