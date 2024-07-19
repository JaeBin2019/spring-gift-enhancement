package gift.option.controller;

import gift.global.response.ResultCode;
import gift.global.response.ResultResponseDto;
import gift.global.response.SimpleResultResponseDto;
import gift.global.utils.ResponseHelper;
import gift.option.domain.Option;
import gift.option.dto.OptionListResponseDto;
import gift.option.dto.OptionRequestDto;
import gift.option.dto.OptionResponseDto;
import gift.option.service.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("")
    public ResponseEntity<ResultResponseDto<OptionListResponseDto>> getAllOptions() {
        OptionListResponseDto optionListResponseDto = optionService.getAllOptions();
        return ResponseHelper.createResponse(ResultCode.GET_ALL_MEMBERS_SUCCESS, optionListResponseDto);
    }

    @GetMapping("/products/{product_id}")
    public ResponseEntity<ResultResponseDto<OptionListResponseDto>> getOptionsByProductId(@PathVariable(name = "product_id") Long productId) {
        OptionListResponseDto optionListResponseDto = optionService.getOptionsByProductId(productId);
        return ResponseHelper.createResponse(ResultCode.GET_MEMBER_BY_ID_SUCCESS, optionListResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponseDto<OptionResponseDto>> getOptionById(@PathVariable(name = "id") Long id) {
        OptionResponseDto optionResponseDto = optionService.getOptionById(id);
        return ResponseHelper.createResponse(ResultCode.GET_MEMBER_BY_ID_SUCCESS, optionResponseDto);
    }

    @PostMapping("")
    public ResponseEntity<SimpleResultResponseDto> createOption(@RequestBody OptionRequestDto optionRequestDto) {
        optionService.createOption(optionRequestDto.toOptionServiceDto());
        return ResponseHelper.createSimpleResponse(ResultCode.CREATE_MEMBER_SUCCESS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleResultResponseDto> updateOption(@PathVariable(name = "id") Long id, @RequestBody OptionRequestDto optionRequestDto) {
        optionService.updateOption(optionRequestDto.toOptionServiceDto(id));
        return ResponseHelper.createSimpleResponse(ResultCode.UPDATE_MEMBER_SUCCESS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleResultResponseDto> deleteOption(@PathVariable(name = "id") Long id) {
        optionService.deleteOption(id);
        return ResponseHelper.createSimpleResponse(ResultCode.DELETE_PRODUCT_SUCCESS);
    }
}
