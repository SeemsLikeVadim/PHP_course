package com.example.php_course2.web.dto;

public class DeputyDto {
    private String name;

    private long id;
    private String party;
    private int votes;
    public DeputyDto(){

    }

    public DeputyDto(String name, String party) {
        super();
        this.name = name;
        this.party = party;
    }

    public DeputyDto(String name, String party, int votes, long id) {
        super();
        this.name = name;
        this.party = party;
        this.votes = votes;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
