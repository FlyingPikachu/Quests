/*******************************************************************************************************
 * Continued by FlyingPikachu/HappyPikachu with permission from _Blackvein_. All rights reserved.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN
 * NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ****************************************************************************************************** */
package me.blackvein.quests.util.particle;

import java.util.Map;
import java.util.stream.Stream;
import org.bukkit.util.Vector;

public enum PreBuiltParticle {

    ENCHANT("enchant", 0, 1, 0, 1, 10),
    CRIT("crit", 0, 0, 0, .35f, 3),
    SPELL("spell", 0, 0, 0, 1, 3),
    MAGIC_CRIT("magiccrit", 0, 0, 0, .35f, 3),
    MOB_SPELL("mobspell", 0, 0, 0, 1, 3),
    NOTE("note", 0, 0, 0, 1, 1, new Vector(0, .5, 0)),
    PORTAL("portal", 0, 0, 0, 1, 5),
    DUST("dust", 0, 0, 0, 1, 1, new Vector(0, .5, 0)),
    WITCH("witch", 0, 0, 0, 1, 3),
    SNOWBALL("snowball", 0, 0, 0, 1, 3),
    SPLASH("splash", 0, 0, 0, 1, 4, new Vector(0, .5, 0)),
    SMOKE("smoke", 0, 1, 0, 1, 20);

    private static Map<String, PreBuiltParticle> FROM_IDENTIFIER;

    static {
        Stream.of(values()).forEach(p -> FROM_IDENTIFIER.put(p.identifier, p));
    }

    private String identifier;
    private float offsetX, offsetY, offsetZ, speed;
    private int count;
    private Vector vector;

    PreBuiltParticle(String identifier, float offsetX, float offsetY, float offsetZ, float speed, int count) {
        this.identifier = identifier;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.speed = speed;
        this.count = count;
    }

    PreBuiltParticle(String identifier, float offsetX, float offsetY, float offsetZ, float speed, int count, Vector vector) {
        this(identifier, offsetX, offsetY, offsetZ, speed, count);
        this.vector = vector;
    }

    public String getIdentifier() {
        return identifier;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public float getOffsetZ() {
        return offsetZ;
    }

    public float getSpeed() {
        return speed;
    }

    public int getCount() {
        return count;
    }

    /**
     * Returns the vector applied to the default spawn location or null if the location isn't modified.
     *
     * @return the vector applied to the default spawn location or null if the location isn't modified
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Returns the PreBuiltParticle represented by the specified identifier.
     *
     * @param identifier the identifier
     * @return the PreBuiltParticle represented by the specified identifier
     */
    public static PreBuiltParticle fromIdentifier(String identifier) {
        return FROM_IDENTIFIER.get(identifier);
    }

}
