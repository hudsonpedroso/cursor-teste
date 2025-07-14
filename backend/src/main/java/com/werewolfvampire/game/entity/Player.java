package com.werewolfvampire.game.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "faction")
    private Faction faction;

    @Column(name = "level")
    private Integer level = 1;

    @Column(name = "experience")
    private Long experience = 0L;

    @Column(name = "power")
    private Long power = 100L;

    @Column(name = "clicks_per_second")
    private Double clicksPerSecond = 1.0;

    @Column(name = "total_clicks")
    private Long totalClicks = 0L;

    @Column(name = "coins")
    private Long coins = 0L;

    @Column(name = "territory_controlled")
    private Integer territoryControlled = 0;

    @Column(name = "battles_won")
    private Integer battlesWon = 0;

    @Column(name = "battles_lost")
    private Integer battlesLost = 0;

    @Column(name = "last_activity")
    private LocalDateTime lastActivity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Player() {
        this.createdAt = LocalDateTime.now();
        this.lastActivity = LocalDateTime.now();
    }

    public Player(User user, Faction faction) {
        this();
        this.user = user;
        this.faction = faction;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Double getClicksPerSecond() {
        return clicksPerSecond;
    }

    public void setClicksPerSecond(Double clicksPerSecond) {
        this.clicksPerSecond = clicksPerSecond;
    }

    public Long getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(Long totalClicks) {
        this.totalClicks = totalClicks;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }

    public Integer getTerritoryControlled() {
        return territoryControlled;
    }

    public void setTerritoryControlled(Integer territoryControlled) {
        this.territoryControlled = territoryControlled;
    }

    public Integer getBattlesWon() {
        return battlesWon;
    }

    public void setBattlesWon(Integer battlesWon) {
        this.battlesWon = battlesWon;
    }

    public Integer getBattlesLost() {
        return battlesLost;
    }

    public void setBattlesLost(Integer battlesLost) {
        this.battlesLost = battlesLost;
    }

    public LocalDateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LocalDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}