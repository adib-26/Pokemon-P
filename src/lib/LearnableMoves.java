package src.lib;


    public class LearnableMoves implements Comparable<LearnableMoves> {
        Moves move;
        int level;
    
        public LearnableMoves(Moves move, int level){
            this.move = move;
            this.level = level;
        }
        public void setMove(Moves move){this.move = move;}
        public void setLevel(int level){this.level = level;}
    
        public Moves getMove(){return this.move;}
        public int getLevel(){return this.level;}
        @Override
        public int compareTo(LearnableMoves o) {
            if(this.getLevel()>o.getLevel()){return 1;}
            else if(this.getLevel()<o.getLevel()){return -1;}
            return 0;
        }
    
       
    
        
    
    
    }
    

