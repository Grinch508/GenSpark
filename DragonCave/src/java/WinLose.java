public class WinLose {
    public String winLine = "\n\nYou approach the cave...\n"+
            "It is dark and spooky...\n"+
            "A large treasure appears in front of you!\n"+
            "YOU WIN!!!";
    public String getWinLine(String winLine){
        this.winLine = winLine;
        return winLine;
    }
    public String loseLine = "\n\nYou approach the cave...\n"+
            "It is dark and spooky...\n"+
            "A large treasure appears in front of you!\n"+
            "YOU LOSE!!!\n";
    public String getLoseLine(String loseLine){
        this.loseLine = loseLine;
        return loseLine;
    }
}
