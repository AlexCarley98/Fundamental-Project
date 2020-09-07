function displaySchemes(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                // adding an element to the body example
                // let elem = document.createElement('div');
                // elem.textContent = "hello world";
                // document.body.appendChild(elem);
                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    // adding title to the body of the page
                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    header.textContent = "Scheme name: " + el.name;
                    elem.appendChild(header);
                    el.paints.forEach(paints => {
                        console.log(paints) // print all paints for each schemes
                        let name = document.createElement('p');
                        let colour = document.createElement('p');
                        let stock = document.createElement('p');
                        name.textContent = "Title: " + paints.name;
                        colour.textContent = "Colour: " + paints.colour;
                        stock.numberValue = "Stock: " + paints.stock;
                        elem.appendChild(name);
                        elem.appendChild(colour);
                        elem.appendChild(stock);
                    })
                    document.body.appendChild(elem);
                });


            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://localhost:9090/getAllSchemes");
    req.send();
}