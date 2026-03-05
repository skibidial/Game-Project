import CardGame.CardAtk;
import CardGame.CardDf;
import CardGame.CardUlt;
import character.Operator;
import character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    private Operator operator;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        // ลำดับพารามิเตอร์ของโค้ดจริง: hp, maxHp, strength, defence
        // เซ็ตให้ Chief เริ่มมามีเลือด 100/100, พลังโจมตี 20, พลังป้องกัน 10
        operator = new Operator(100, 100, 20, 10);

        // Enemy มีเลือด 100/100, พลังโจมตี 15, พลังป้องกัน 5
        enemy = new Enemy(100, 100, 15, 5);
    }

    // =========================================================
    // กลุ่มที่ 1: ทดสอบ Logic ของ Character และ State เบื้องต้น
    // =========================================================

    @Test
    void testInitialCharacterStatus() {
        // เหตุผลที่ทดสอบ: เพื่อยืนยันว่าคลาสถูกสร้างขึ้นมาพร้อมค่าเริ่มต้นที่ถูกต้อง และใช้ระบบ UltOrbs แทน MP
        assertEquals(100, operator.getHp(), "HP เริ่มต้นของ Chief ควรเป็น 100");
        assertEquals(0, operator.getUltOrbs(), "UltOrbs เริ่มต้นของ Chief ควรเป็น 0");
        assertFalse(operator.isGuard(), "สถานะป้องกันตอนเริ่มเกมต้องเป็น false เสมอ");
    }

    // =========================================================
    // กลุ่มที่ 2: ทดสอบ Logic ของคลาสหมวด CardGame (การโจมตี/ป้องกัน/อัลติ)
    // =========================================================

    @Test
    void testNormalAttackDamageCalculation() {
        // เหตุผลที่ทดสอบ: ตรวจสอบสูตรคำนวณดาเมจพื้นฐาน ว่านำพลังโจมตีหักล้างกับเกราะศัตรูถูกต้อง และเก็บ Orb ได้
        CardAtk atkCard = new CardAtk(30, 0, operator);

        // ทดสอบการเรียกใช้เมธอด attack
        atkCard.attack(enemy);

        // ดาเมจที่ควรจะเป็น: max(0, (พลังการ์ด 30 + พลัง chief 20) - เกราะศัตรู 5) = 45
        // เลือดศัตรู: 100 - 45 = 55
        assertEquals(55, enemy.getHp(), "เลือดศัตรูต้องลดลง 45 หน่วยตามสมการคำนวณดาเมจ");
        assertEquals(1, operator.getUltOrbs(), "การโจมตีต้องเพิ่ม UltOrbs 1 แต้ม");
    }

    @Test
    void testGuardStatusActivation() {
        // เหตุผลที่ทดสอบ: ยืนยันว่าการ์ดป้องกันเปลี่ยน state (isGuard), เพิ่มเกราะ และเพิ่ม Orb ได้จริง
        CardDf dfCard = new CardDf(0, 40, operator);

        dfCard.guard();

        assertTrue(operator.isGuard(), "เมื่อเรียกใช้ guard() สถานะ isGuard ต้องถูกเปลี่ยนเป็น true");
        assertEquals(50, operator.getDefence(), "พลังป้องกันต้องเพิ่มขึ้นเป็น 50 (ค่าเดิม 10 + การ์ด 40)");
        assertEquals(1, operator.getUltOrbs(), "การป้องกันต้องเพิ่ม UltOrbs 1 แต้ม");
    }

    @Test
    void testUltimateSkillSuccess() {
        // เหตุผลที่ทดสอบ: ตรวจสอบการใช้ท่าไม้ตายเมื่อ Orbs ครบ 3
        // หมายเหตุ: ตามโค้ดจริง อัลติของคุณไม่ได้ทำดาเมจศัตรู แต่เป็นการบัฟโจมตี + ฮีลเลือด
        operator.setHp(10); // ลดเลือดตัวละครหลักเพื่อทดสอบระบบฮีล
        operator.setUltObs(3); // จำลองว่าเก็บครบ 3 Orbs (เรียกตามโค้ดจริงที่สะกดตกตัว r)

        CardUlt ultCard = new CardUlt(50, 20, operator);

        ultCard.Ult();

        // 1. เช็คว่า Orbs ถูกล้างค่ากลับเป็น 0
        assertEquals(0, operator.getUltOrbs(), "UltOrbs ต้องกลับเป็น 0 หลังจากใช้ท่าไม้ตาย");

        // 2. เช็คบัฟพลังโจมตี (ค่าเดิม 20 + การ์ด 50 = 70)
        assertEquals(70, operator.getStrength(), "พลังโจมตีต้องเพิ่มขึ้น 50 หน่วย");

        // 3. เช็คการฮีลเลือด (เลือดเดิม 10 + พลังการ์ด 50 + เกราะการ์ด 20 = 80)
        assertEquals(80, operator.getHp(), "เลือดต้องได้รับการฟื้นฟูตามค่าพลังของการ์ดอัลติ");
    }

    @Test
    void testUltimateSkillFailNotEnoughOrbs() {
        // เหตุผลที่ทดสอบ: ป้องกันบั๊กที่ผู้เล่นอาจใช้อัลติได้แม้ Orbs ไม่ถึง 3
        operator.setUltObs(2); // จำลองว่ามีแค่ 2 Orbs
        CardUlt ultCard = new CardUlt(100, 0, operator);

        ultCard.Ult();

        // พลังโจมตีต้องเท่าเดิม เพราะบัฟไม่สำเร็จ
        assertEquals(20, operator.getStrength(), "พลังโจมตีต้องเท่าเดิมหาก Orbs ไม่พอใช้อัลติ");

        // เช็ก Logic ที่คุณตั้งใจให้เมื่อกดอัลติแล้ว Orbs รีเซ็ตเป็น 0 เสมอ
        assertEquals(0, operator.getUltOrbs(), "UltOrbs ต้องถูกรีเซ็ตแม้จะใช้ไม่สำเร็จตาม Mechanic ของเกม");
    }

    // =========================================================
    // กลุ่มที่ 3: ทดสอบ Edge Cases (บั๊กที่อาจเกิดขึ้นเมื่อค่าเป็นสุดขั้ว)
    // =========================================================

    @Test
    void testNegativeDamagePrevention() {
        // เหตุผลที่ทดสอบ: ดักจับบั๊ก "ตีแล้วเลือดเพิ่ม" ในกรณีที่ศัตรูมีเกราะหนากว่าพลังโจมตี
        Enemy tankEnemy = new Enemy(100, 100, 15, 500); // เกราะหนา 500
        CardAtk weakAtkCard = new CardAtk(20, 0, operator);

        weakAtkCard.attack(tankEnemy);

        // เลือดศัตรูต้องไม่เพิ่มขึ้น และไม่ลดลง (รับดาเมจ 0)
        assertEquals(100, tankEnemy.getHp(), "ดาเมจรวมต้องถูกปัดเป็น 0 ไม่ทำให้เลือดศัตรูเพิ่มขึ้น");
    }
}