
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2)
			return getResultWhenAreEquals();
        else if (m_score1>=4 || m_score2>=4)
			return getResultWhenIsMoreThan4();
        else
		return getResultWhenIsLessThan4();

    }

    private String getResultWhenIsLessThan4() {
        String score = "";
        for (int i=1; i<3; i++)
        {
            score = getPlayerAndScore(i, score);
        }
        return score;
    }

    private String getPlayerAndScore(int i, String score) {
        int tempScore;
        if (i ==1) tempScore = m_score1;
        else { score +="-"; tempScore = m_score2;}
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
        }
        return score;
    }

    private String getResultWhenIsMoreThan4() {
        String score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else
			score = "Win for player2";
        return score;
    }

    private String getResultWhenAreEquals() {
		return switch (m_score1) {
			case 0 -> "Love-All";
			case 1 -> "Fifteen-All";
			case 2 -> "Thirty-All";
			default -> "Deuce";
		};
    }
}
