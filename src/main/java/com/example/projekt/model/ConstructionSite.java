package com.example.projekt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "buildings")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ConstructionSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_building")
    private int constructionSiteId;

    @Column(name = "name")
    private String name;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "planned_start_date")
    private Date plannedStartDate;

    @Column(name = "planned_end_date")
    private Date plannedEndDate;

    @Column(name = "real_end_date")
    private Date realEndDate;

    @Column(name = "real_start_date")
    private Date realStartDate;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(
            mappedBy = "constructionSite", //dwukierunkowa relacja, pomogło przy sypaniu się aplikacji,
            // gdy odwoływało się do relacji powiązanych manytoone
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Costs> costsList;


    @OneToMany(
            mappedBy = "constructionSite", //dwukierunkowa relacja, pomogło przy sypaniu się aplikacji,
            // gdy odwoływało się do relacji powiązanych manytoone
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Hours> hoursList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_on_buildings",
            joinColumns = @JoinColumn(name = "buildings_id_building"),
            inverseJoinColumns = @JoinColumn(name = "users_id_user")
    )
    private Set<User> users = new HashSet<>();

   @OneToMany(
           mappedBy = "constructionSite", //dwukierunkowa relacja, pomogło przy sypaniu się aplikacji,
                                        // gdy odwoływało się do relacji powiązanych manytoone
           cascade = CascadeType.ALL,
           orphanRemoval = true
   )
   private List<DailyWorkReport> dailyWorkReport;

    @OneToMany(
            mappedBy = "constructionSite", //dwukierunkowa relacja, pomogło przy sypaniu się aplikacji,
            // gdy odwoływało się do relacji powiązanych manytoone
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BuildingDailyReports> buildingDailyReports;


    public ConstructionSite() {
    }

    public ConstructionSite(String name, String buildingNumber, String coordinates, Date plannedStartDate, Date plannedEndDate, Date realEndDate, Date realStartDate, Set<User> users) {
        this.name = name;
        this.buildingNumber = buildingNumber;
        this.coordinates = coordinates;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.realEndDate = realEndDate;
        this.realStartDate = realStartDate;
        this.users = users;
    }

    public int getConstructionSiteId() {
        return constructionSiteId;
    }

    public void setConstructionSiteId(int constructionSiteId) {
        this.constructionSiteId = constructionSiteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public Date getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public List<DailyWorkReport> getDailyWorkReport() {
        return dailyWorkReport;
    }

    public void setDailyWorkReport(List<DailyWorkReport> dailyWorkReport) {
        this.dailyWorkReport = dailyWorkReport;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Costs> getCostsList() {
        return costsList;
    }

    public void setCostsList(List<Costs> costsList) {
        this.costsList = costsList;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<BuildingDailyReports> getBuildingDailyReports() {
        return buildingDailyReports;
    }

    public void setBuildingDailyReports(List<BuildingDailyReports> buildingDailyReports) {
        this.buildingDailyReports = buildingDailyReports;
    }

    public List<Hours> getHoursList() {
        return hoursList;
    }

    public void setHoursList(List<Hours> hoursList) {
        this.hoursList = hoursList;
    }
}
