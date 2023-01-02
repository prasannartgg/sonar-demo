package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.PosItemRollupEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface PosItemRollupRepository extends CrudRepository<PosItemRollupEntity, Long> {
    List<PosItemRollupEntity> findPosItemRollupEntityByProductId(BigInteger productId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tggcsodr.pos_item_rollup(\n" +
            "\tproduct_id, web_ready, web_ready_b2b, onhand_qty, pick_com_qty, bkord_com_qty, hold_com_qty, outbound_qty, web_min_qty, last_recpt_datei, nat_web_onhand_qty, vic_web_onhand_quantity, tas_web_onhand_quantity, qld_web_onhand_quantity, nsw_web_onhand_quantity, act_web_onhand_quantity, wa_web_onhand_quantity, sa_web_onhand_quantity, nt_web_onhand_quantity, created_datetime, last_modified_datetime, onhand_val, onorder_qty, onorder_val, onhand_avg_val, last_sale_datei, onhand_median_val, prod_nbr, inv_name)\n" +
            "\tVALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25, ?26, ?27, ?28, ?29)", nativeQuery = true)
    void insertPostItemRollUpEntity(BigInteger product_id, String web_ready,
                                    String web_ready_b2b,
                                    BigInteger onhand_qty,
                                    BigInteger pick_com_qty,
                                    BigInteger bkord_com_qty,
                                    BigInteger hold_com_qty,
                                    BigInteger outbound_qty,
                                    BigInteger web_min_qty,
                                    LocalDateTime last_recpt_datei,
                                    BigInteger nat_web_onhand_qty,
                                    BigInteger vic_web_onhand_quantity,
                                    BigInteger tas_web_onhand_quantity,
                                    BigInteger qld_web_onhand_quantity,
                                    BigInteger nsw_web_onhand_quantity,
                                    BigInteger act_web_onhand_quantity,
                                    BigInteger wa_web_onhand_quantity,
                                    BigInteger sa_web_onhand_quantity,
                                    BigInteger nt_web_onhand_quantity,
                                    LocalDateTime created_datetime,
                                    LocalDateTime last_modified_datetime,
                                    BigInteger onhand_val,
                                    BigInteger onorder_qty,
                                    BigInteger onorder_val,
                                    BigInteger onhand_avg_val,
                                    LocalDateTime last_sale_datei,
                                    BigInteger onhand_median_val,
                                    String prod_nbr, String inv_name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tggcsodr.pos_item_rollup\n" +
            "\tSET   web_ready=?2, web_ready_b2b=?3, onhand_qty=?4, pick_com_qty=?5, bkord_com_qty=?6, hold_com_qty=?7, outbound_qty=?8, web_min_qty=?9, last_recpt_datei=?10, nat_web_onhand_qty=?11, vic_web_onhand_quantity=?12, tas_web_onhand_quantity=?13, qld_web_onhand_quantity=?14, nsw_web_onhand_quantity=?15, act_web_onhand_quantity=?16, wa_web_onhand_quantity=?17, sa_web_onhand_quantity=?18, nt_web_onhand_quantity=?19, created_datetime=?20, last_modified_datetime=?21, onhand_val=?22, onorder_qty=?23, onorder_val=?24, onhand_avg_val=?25, last_sale_datei=?26, onhand_median_val=?27, prod_nbr=?28, inv_name=?29\n" +
            "\tWHERE product_id=?1;", nativeQuery = true)
    void updatePostItemRollUpEntity(BigInteger product_id, String web_ready,
                                    String web_ready_b2b,
                                    BigInteger onhand_qty,
                                    BigInteger pick_com_qty,
                                    BigInteger bkord_com_qty,
                                    BigInteger hold_com_qty,
                                    BigInteger outbound_qty,
                                    BigInteger web_min_qty,
                                    LocalDateTime last_recpt_datei,
                                    BigInteger nat_web_onhand_qty,
                                    BigInteger vic_web_onhand_quantity,
                                    BigInteger tas_web_onhand_quantity,
                                    BigInteger qld_web_onhand_quantity,
                                    BigInteger nsw_web_onhand_quantity,
                                    BigInteger act_web_onhand_quantity,
                                    BigInteger wa_web_onhand_quantity,
                                    BigInteger sa_web_onhand_quantity,
                                    BigInteger nt_web_onhand_quantity,
                                    LocalDateTime created_datetime,
                                    LocalDateTime last_modified_datetime,
                                    BigInteger onhand_val,
                                    BigInteger onorder_qty,
                                    BigInteger onorder_val,
                                    BigInteger onhand_avg_val,
                                    LocalDateTime last_sale_datei,
                                    BigInteger onhand_median_val,
                                    String prod_nbr, String inv_name);
}
