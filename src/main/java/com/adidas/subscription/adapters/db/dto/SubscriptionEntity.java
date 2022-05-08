package com.adidas.subscription.adapters.db.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Subscription entity, define database entity for subscription.
 */
@Data
@Entity(name = "subscriptions")
@Table(
        name="subscriptions",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"email", "newsletterId"})
)
public class SubscriptionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String email;

    private String name;

    private String gender;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private boolean consent;

    @Column(nullable = false)
    private String newsletterId;

}
