package entity;

public class Coach {
    private Integer coach_id;
    private String coach_name;
    private String coach_grade;
    private double coach_price;
    private String coach_brief;
    private String coach_course;
    private int coach_withPeople;    // 每个教练带的人数
    private String coachImage;

    public Coach() {
    }

    public Coach(Integer coach_id, String coach_name, String coach_grade, double coach_price, String coach_brief, String coach_course, int coach_withPeople) {
        this.coach_id = coach_id;
        this.coach_name = coach_name;
        this.coach_grade = coach_grade;
        this.coach_price = coach_price;
        this.coach_brief = coach_brief;
        this.coach_course = coach_course;
        this.coach_withPeople = coach_withPeople;
    }

    public Coach(Integer coach_id, String coach_name, String coach_grade, double coach_price, String coach_brief,
                 String coach_course, int coach_withPeople, String coachImage) {
        this.coach_id = coach_id;
        this.coach_name = coach_name;
        this.coach_grade = coach_grade;
        this.coach_price = coach_price;
        this.coach_brief = coach_brief;
        this.coach_course = coach_course;
        this.coach_withPeople = coach_withPeople;
        this.coachImage = coachImage;
    }

    public String getCoachImage() {
        return coachImage;
    }

    public void setCoachImage(String coachImage) {
        this.coachImage = coachImage;
    }

    public Integer getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(Integer coach_id) {
        this.coach_id = coach_id;
    }

    public String getCoach_name() {
        return coach_name;
    }

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public String getCoach_grade() {
        return coach_grade;
    }

    public void setCoach_grade(String coach_grade) {
        this.coach_grade = coach_grade;
    }

    public double getCoach_price() {
        return coach_price;
    }

    public void setCoach_price(double coach_price) {
        this.coach_price = coach_price;
    }

    public String getCoach_brief() {
        return coach_brief;
    }

    public void setCoach_brief(String coach_brief) {
        this.coach_brief = coach_brief;
    }

    public String getCoach_course() {
        return coach_course;
    }

    public void setCoach_course(String coach_course) {
        this.coach_course = coach_course;
    }

    public int getCoach_withPeople() {
        return coach_withPeople;
    }

    public void setCoach_withPeople(int coach_withPeople) {
        this.coach_withPeople = coach_withPeople;
    }
}
