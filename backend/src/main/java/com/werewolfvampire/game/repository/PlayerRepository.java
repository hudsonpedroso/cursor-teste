package com.werewolfvampire.game.repository;

import com.werewolfvampire.game.entity.Player;
import com.werewolfvampire.game.entity.Faction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByUserId(Long userId);
    
    List<Player> findByFaction(Faction faction);
    
    @Query("SELECT p FROM Player p ORDER BY p.power DESC")
    List<Player> findTopPlayersByPower();
    
    @Query("SELECT p FROM Player p WHERE p.faction = :faction ORDER BY p.power DESC")
    List<Player> findTopPlayersByFactionAndPower(Faction faction);
    
    @Query("SELECT COUNT(p) FROM Player p WHERE p.faction = :faction")
    Long countByFaction(Faction faction);
}