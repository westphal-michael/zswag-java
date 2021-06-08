package zswag.java.rest.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Float64ArrayOpenApi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-08T12:34:06.016125600+02:00[Europe/Berlin]")


public class Float64ArrayOpenApi   {
  @JsonProperty("fromList")
  @Valid
  private List<Double> fromList = null;

  public Float64ArrayOpenApi fromList(List<Double> fromList) {
    this.fromList = fromList;
    return this;
  }

  public Float64ArrayOpenApi addFromListItem(Double fromListItem) {
    if (this.fromList == null) {
      this.fromList = new ArrayList<Double>();
    }
    this.fromList.add(fromListItem);
    return this;
  }

  /**
   * Get fromList
   * @return fromList
   **/
  @ApiModelProperty(value = "")
  
    public List<Double> getFromList() {
    return fromList;
  }

  public void setFromList(List<Double> fromList) {
    this.fromList = fromList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Float64ArrayOpenApi float64Array = (Float64ArrayOpenApi) o;
    return Objects.equals(this.fromList, float64Array.fromList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Float64ArrayOpenApi {\n");
    
    sb.append("    fromList: ").append(toIndentedString(fromList)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
