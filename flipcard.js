//assign random colors to the cards, after 10secs, the cards rotateZ(360deg) to a white card.
//Add event listener(click) to cards,if clicked, then rotate 360, then if second flipped matches, points ++; Keep track of trials.
//When all cards are revealed, the game is over.
opened = 0;
color=[];
clicked=[];
point = document.getElementById("pts");
trials = document.getElementById("trials");
c = document.getElementsByClassName("c");
colors = ["#32a8a8","#a88332","#a83232","#55a832","#9032a8","#808080","#32a8a8","#a88332","#a83232","#55a832","#9032a8","#808080"];
/**
 * 
 * @param  min minimum random value that can be returned
 * @param  max maximum random value that can be returned
 * @returns a random integer between min and max(excluded) 
 */
function getRandomInt(min, max){
    return Math.floor(Math.random() * (max - min)) + min;
}

/**
 * assignClrs assigns a random color to each div in the grid layout
 * It iterates through each divs,uses the getRandomInt function to generate a random index, then deleting color[index] to ensure 
 * that a color is not assigned more than once...well in this case,twice(since each color is repeated twice in the colors array)
 */
function assignClrs(){
    for(let i of c){
        let clr = i.getAttribute("style");
        rand = getRandomInt(0,colors.length);
        i.setAttribute("style", `--clr: ${colors[rand]}`);
        colors.splice(rand,1);
    }
}
assignClrs();

setTimeout(()=>{
    for(j of c){
        j.classList.toggle("dull");
    }
    for(let i of c){
        i.addEventListener("click",()=>{
            //i.classList.toggle("dull");
            clicked.push(i.getAttribute("id"));
            i.setAttribute("class", "active");
            color.push(i.getAttribute("style"));
            opened++;
            if(opened === 2 ){
                trials.innerHTML++;
                if(color[0] === color[1]){
                    for(r of clicked){
                        ref = document.getElementById(r);
                        ref.setAttribute("class","done");
                    }
                    point.innerHTML++;
                }
                else{
                    for( j of clicked){
                        ref = document.getElementById(j);
                        ref.setAttribute("class","c dull");
                    }
                }
                color.splice(0,color.length);
                clicked.splice(0,clicked.length);
                opened = 0;
            }
        })
    }
    
},10000);