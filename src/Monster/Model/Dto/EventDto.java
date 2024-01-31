package Monster.Model.Dto;

public class EventDto {

    //1. 필드
    private int eno;
    private String eimg;
    private int statUp;
    private int statDown;

    //2.생성자
    EventDto(){}

    public EventDto(int eno, String eimg, int statUp, int statDown) {
        this.eno = eno;
        this.eimg = eimg;
        this.statUp = statUp;
        this.statDown = statDown;
    }

    //3.메소드
    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEimg() {
        return eimg;
    }

    public void setEimg(String eimg) {
        this.eimg = eimg;
    }

    public int getStatUp() {
        return statUp;
    }

    public void setStatUp(int statUp) {
        this.statUp = statUp;
    }

    public int getStatDown() {
        return statDown;
    }

    public void setStatDown(int statDown) {
        this.statDown = statDown;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "eno=" + eno +
                ", eimg='" + eimg + '\'' +
                ", statUp=" + statUp +
                ", statDown=" + statDown +
                '}';
    }
}//class e
