package shop.mtcoding.todayhome.ready;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

@Getter
@Setter
@Table(name = "ready_tb")
@NoArgsConstructor
@Entity
public class Ready {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String cid;
    private int taxFreeAmount;
    private String approvalUrl;
    private String cancelUrl;
    private String failUrl;

    @Builder
    public Ready(int id, String cid, int taxFreeAmount, String approvalUrl, String cancelUrl, String failUrl) {
        this.id = id;
        this.cid = cid;
        this.taxFreeAmount = taxFreeAmount;
        this.approvalUrl = approvalUrl;
        this.cancelUrl = cancelUrl;
        this.failUrl = failUrl;
    }
}
