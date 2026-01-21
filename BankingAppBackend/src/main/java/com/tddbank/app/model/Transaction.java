//package com.tddbank.app.model;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//import org.hibernate.annotations.CreationTimestamp;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.PrePersist;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Transaction {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column(nullable=false,unique=true)
//	private String transactionId;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "source_account_id")
//    private Account sourceAccount;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "destination_account_id")
//    private Account destinationAccount;
//    
//    @Column(nullable = false, precision = 19, scale = 2)
//    private BigDecimal amount;
//    
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private TransactionType type;
//    
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private TransactionStatus status = TransactionStatus.PENDING;
//    
//    private String description;
//    
//    private String category; 
//    
//    @CreationTimestamp
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//    
//    private LocalDateTime completedAt;
//    
//    public enum TransactionType {
//        DEPOSIT,
//        WITHDRAWAL,
//        TRANSFER,
//        PAYMENT,
//        REFUND
//    }
//    
//    public enum TransactionStatus {
//        PENDING,
//        COMPLETED,
//        FAILED,
//        CANCELLED
//    }
//    
//    @PrePersist
//    public void generateTransactionId() {
//        if (this.transactionId == null) {
//            this.transactionId = "TXN" + System.currentTimeMillis() + 
//                                (int)(Math.random() * 10000);
//        }
//    }
//	
//}
