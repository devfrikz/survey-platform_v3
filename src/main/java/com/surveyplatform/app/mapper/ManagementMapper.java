package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.CrmProspectDto;
import com.surveyplatform.app.dto.FacebookMarketPlaceDto;
import com.surveyplatform.app.dto.FbMarketplaceVehicleDto;
import com.surveyplatform.app.dto.ReferralDto;
import com.surveyplatform.app.dto.ShowroomVisitDto;
import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.dto.TradeInDto;
import com.surveyplatform.app.dto.VehicleDto;
import com.surveyplatform.app.persistance.entities.CrmProspect;
import com.surveyplatform.app.persistance.entities.FacebookMarketPlace;
import com.surveyplatform.app.persistance.entities.FbMarketplaceVehicle;
import com.surveyplatform.app.persistance.entities.FormularioCustomerNeed;
import com.surveyplatform.app.persistance.entities.FormularioDailyPlanner;
import com.surveyplatform.app.persistance.entities.FormularioDeliveryChecklist;
import com.surveyplatform.app.persistance.entities.FormularioEndOfDay;
import com.surveyplatform.app.persistance.entities.FormularioSsi1000;
import com.surveyplatform.app.persistance.entities.Referral;
import com.surveyplatform.app.persistance.entities.ShowroomVisit;
import com.surveyplatform.app.persistance.entities.TradeIn;
import com.surveyplatform.app.persistance.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ManagementMapper {
    ManagementMapper MAPPER = Mappers.getMapper(ManagementMapper.class);

    @Mapping(source = "date", target = "date")
    @Mapping(source = "deliveredUpToDate", target = "deliveredUpToDate")
    @Mapping(source = "daysGone", target = "daysGone")
    @Mapping(source = "averageSoldPerDay", target = "averageSoldPerDay")
    @Mapping(source = "daysThisMonth", target = "daysThisMonth")
    @Mapping(source = "tracking", target = "tracking")
    @Mapping(source = "goal", target = "goal")
    @Mapping(source = "plusOrMinusGoal", target = "plusOrMinusGoal")
    @Mapping(target = "vehicles", ignore = true)
    @Mapping(target = "showroomVisits", ignore = true)
    @Mapping(target = "fbMarketplaceVehicles", ignore = true)
    @Mapping(target = "tradeIns", ignore = true)
    @Mapping(target = "referrals", ignore = true)
    FormularioDailyPlanner toDailyPlannerEntity(SubmittedFormDto submittedFormDto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "vehicle", target = "vehicleName")
    @Mapping(source = "hour", target = "hour")
    @Mapping(source = "minute", target = "minute")
    @Mapping(source = "amPm", target = "amPm")
    Vehicle toVehicleEntity(VehicleDto vehicleDto);

    @Mapping(source = "visitFirstName", target = "visitFirstName")
    @Mapping(source = "visitLastName", target = "visitLastName")
    @Mapping(source = "visitVehicle", target = "visitVehicle")
    @Mapping(source = "dealRequirement", target = "dealRequirement")
    ShowroomVisit toShowroomVisitEntity(ShowroomVisitDto showroomVisitDto);

    default List<Vehicle> mapVehicles(List<VehicleDto> vehicleDtos, FormularioDailyPlanner dailyPlanner) {
        return vehicleDtos.stream()
                .map(vehicleDto -> {
                    Vehicle vehicle = toVehicleEntity(vehicleDto);
                    vehicle.setFormularioDailyPlanner(dailyPlanner);
                    return vehicle;
                })
                .toList();
    }

    default List<ShowroomVisit> mapShowroomVisits(List<ShowroomVisitDto> showroomVisitDtos, FormularioDailyPlanner dailyPlanner) {
        return showroomVisitDtos.stream()
                .map(showroomVisitDto -> {
                    ShowroomVisit visit = toShowroomVisitEntity(showroomVisitDto);
                    visit.setFormularioDailyPlanner(dailyPlanner);
                    return visit;
                })
                .toList();
    }

    @Mapping(source = "fbStockNumber", target = "fbStockNumber")
    @Mapping(source = "fbLink", target = "fbLink")
    @Mapping(source = "fbVehicleType", target = "fbVehicleType")
    @Mapping(source = "fbListingPrice", target = "fbListingPrice")
    FbMarketplaceVehicle toFbMarketplaceVehicleEntity(FbMarketplaceVehicleDto fbMarketplaceVehicleDto);

    default List<FbMarketplaceVehicle> mapFbMarketplaceVehicles(List<FbMarketplaceVehicleDto> vehicleDtos, FormularioDailyPlanner dailyPlanner) {
        return vehicleDtos.stream()
                .map(vehicleDto -> {
                    FbMarketplaceVehicle vehicle = toFbMarketplaceVehicleEntity(vehicleDto);
                    vehicle.setFormularioDailyPlanner(dailyPlanner);
                    return vehicle;
                })
                .toList();
    }

    @Mapping(source = "tradeInYear", target = "tradeInYear")
    @Mapping(source = "tradeInMake", target = "tradeInMake")
    @Mapping(source = "tradeInModel", target = "tradeInModel")
    @Mapping(source = "tradeInMileage", target = "tradeInMileage")
    @Mapping(source = "tradeInStockNumber", target = "tradeInStockNumber")
    @Mapping(source = "tradeInDateAcquired", target = "tradeInDateAcquired")
    TradeIn toTradeInEntity(TradeInDto tradeInDto);

    default List<TradeIn> mapTradeIns(List<TradeInDto> tradeInDtos, FormularioDailyPlanner dailyPlanner) {
        return tradeInDtos.stream()
                .map(tradeInDto -> {
                    TradeIn tradeIn = toTradeInEntity(tradeInDto);
                    tradeIn.setFormularioDailyPlanner(dailyPlanner);
                    return tradeIn;
                })
                .toList();
    }

    @Mapping(source = "referralFirstName", target = "referralFirstName")
    @Mapping(source = "referralLastName", target = "referralLastName")
    @Mapping(source = "referralReason", target = "referralReason")
    Referral toReferralEntity(ReferralDto referralDto);

    default List<Referral> mapReferrals(List<ReferralDto> referralDtos, FormularioDailyPlanner dailyPlanner) {
        return referralDtos.stream()
                .map(referralDto -> {
                    Referral referral = toReferralEntity(referralDto);
                    referral.setFormularioDailyPlanner(dailyPlanner);
                    return referral;
                })
                .toList();
    }

    default FormularioDailyPlanner toDailyPlannerEntityWithDetails(SubmittedFormDto submittedFormDto) {
        FormularioDailyPlanner dailyPlanner = toDailyPlannerEntity(submittedFormDto);
        List<Vehicle> vehicles = mapVehicles(submittedFormDto.getVehicles(), dailyPlanner);
        List<ShowroomVisit> showroomVisits = mapShowroomVisits(submittedFormDto.getShowroomVisits(), dailyPlanner);
        List<FbMarketplaceVehicle> fbMarketplaceVehicles = mapFbMarketplaceVehicles(submittedFormDto.getFbMarketplaceVehicles(), dailyPlanner);
        List<TradeIn> tradeIns = mapTradeIns(submittedFormDto.getTradeIns(), dailyPlanner);
        List<Referral> referrals = mapReferrals(submittedFormDto.getReferrals(), dailyPlanner);

        dailyPlanner.setVehicles(vehicles);
        dailyPlanner.setShowroomVisits(showroomVisits);
        dailyPlanner.setFbMarketplaceVehicles(fbMarketplaceVehicles);
        dailyPlanner.setTradeIns(tradeIns);
        dailyPlanner.setReferrals(referrals);

        return dailyPlanner;
    }

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "salesPersonName", target = "salesPersonName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "cityState", target = "cityState")
    @Mapping(source = "zipCode", target = "zipCode")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "hearAboutUs", target = "hearAboutUs")
    @Mapping(source = "vehicleType", target = "vehicleType")
    @Mapping(source = "stockNumber", target = "stockNumber")
    @Mapping(source = "vehicleUse", target = "vehicleUse")
    @Mapping(source = "primaryDriver", target = "primaryDriver")
    @Mapping(source = "otherDrivers", target = "otherDrivers")
    @Mapping(source = "milesDriven", target = "milesDriven")
    @Mapping(source = "motivation", target = "motivation")
    @Mapping(source = "previousBusiness", target = "previousBusiness")
    @Mapping(source = "wants", target = "wants")
    @Mapping(source = "needs", target = "needs")
    @Mapping(source = "currentVehicleYear", target = "currentVehicleYear")
    @Mapping(source = "currentVehicleMake", target = "currentVehicleMake")
    @Mapping(source = "currentVehicleModel", target = "currentVehicleModel")
    @Mapping(source = "currentVehicleMiles", target = "currentVehicleMiles")
    @Mapping(source = "financedBy", target = "financedBy")
    @Mapping(source = "payOff", target = "payOff")
    @Mapping(source = "termLength", target = "termLength")
    @Mapping(source = "currentPayment", target = "currentPayment")
    @Mapping(source = "downPayment", target = "downPayment")
    @Mapping(source = "tradeEquity", target = "tradeEquity")
    @Mapping(source = "likes", target = "likes")
    @Mapping(source = "dislikes", target = "dislikes")
    @Mapping(source = "readyToday", target = "readyToday")
    FormularioCustomerNeed toCustomerNeedEntity(SubmittedFormDto submittedFormDto);

    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "vehicle", target = "vehicle")
    @Mapping(source = "vehicleType", target = "vehicleType")
    @Mapping(source = "copyOfJson", target = "copyOf")
    @Mapping(source = "signedJson", target = "signed")
    @Mapping(source = "titlePlatesJson", target = "titlePlates")
    @Mapping(source = "depositAmount", target = "depositAmount")
    @Mapping(source = "collectedBy", target = "collectedBy")
    @Mapping(expression = "java(stringToLocalDate(submittedFormDto.getCollectedDate()))", target = "collectedDate")
    @Mapping(source = "refund", target = "refund")
    @Mapping(source = "refundedBy", target = "refundedBy")
    @Mapping(expression = "java(stringToLocalDate(submittedFormDto.getRefundDate()))", target = "refundDate")
    @Mapping(source = "downPaymentAmount", target = "downPaymentAmount")
    @Mapping(source = "totalCollected", target = "totalCollected")
    @Mapping(source = "fiInitials", target = "fiInitials")
    @Mapping(expression = "java(stringToLocalDate(submittedFormDto.getFiDate()))", target = "fiDate")
    @Mapping(source = "salesManagerChecklistJson", target = "salesManagerChecklist")
    @Mapping(source = "domCastleChecklistJson", target = "domCastleChecklist")
    @Mapping(source = "notes", target = "notes")
    FormularioDeliveryChecklist toDeliveryChecklistEntity(SubmittedFormDto submittedFormDto);

    @Mapping(source = "customerDeliveriesPhotos", target = "customerDeliveriesPhotos")
    @Mapping(source = "colleaguePostsShared", target = "colleaguePostsShared")
    @Mapping(source = "customerTradeInsPhotos", target = "customerTradeInsPhotos")
    @Mapping(source = "sharedContentFound", target = "sharedContentFound")
    @Mapping(ignore = true, target = "facebookMarketPlaceEntries")
    @Mapping(ignore = true, target = "crmProspects")
    @Mapping(source = "newCarsLeads", target = "newCarsLeads")
    @Mapping(source = "preOwnedLeads", target = "preOwnedLeads")
    @Mapping(source = "newVehiclesDelivered", target = "newVehiclesDelivered")
    @Mapping(source = "newVehiclesLeased", target = "newVehiclesLeased")
    @Mapping(source = "personalAverageSSI", target = "personalAverageSsi")
    @Mapping(source = "newVehicleLastSaleDay", target = "newVehicleLastSaleDay")
    @Mapping(source = "preOwnedVehiclesDelivered", target = "preOwnedVehiclesDelivered")
    @Mapping(source = "dpFinalsSold", target = "dpFinalsSold")
    FormularioEndOfDay toFormularioEndOfDay(SubmittedFormDto submittedFormDto);

    @Mapping(source = "vehicle", target = "vehicle")
    @Mapping(source = "make", target = "make")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "stockNumber", target = "stockNumber")
    FacebookMarketPlace toFacebookMarketPlaceEntity(FacebookMarketPlaceDto dto);

    default List<FacebookMarketPlace> mapFacebookMarketPlaceEntries(List<FacebookMarketPlaceDto> dtos, FormularioEndOfDay formularioEndOfDay) {
        return dtos.stream()
                .map(dto -> {
                    FacebookMarketPlace entry = toFacebookMarketPlaceEntity(dto);
                    entry.setFormularioEndOfDay(formularioEndOfDay);
                    return entry;
                })
                .toList();
    }

    @Mapping(source = "prospectFirstName", target = "prospectFirstName")
    @Mapping(source = "prospectLastName", target = "prospectLastName")
    @Mapping(source = "crmCustomerNumber", target = "crmCustomerNumber")
    CrmProspect toCrmProspectEntity(CrmProspectDto dto);

    default List<CrmProspect> mapCrmProspects(List<CrmProspectDto> dtos, FormularioEndOfDay formularioEndOfDay) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(dto -> {
                    CrmProspect entry = toCrmProspectEntity(dto);
                    entry.setFormularioEndOfDay(formularioEndOfDay);
                    return entry;
                })
                .collect(Collectors.toList());
    }

    default FormularioEndOfDay toFormularioEndOfDayEntityWithDetails(SubmittedFormDto submittedFormDto) {
        FormularioEndOfDay formularioEndOfDay = toFormularioEndOfDay(submittedFormDto);
        List<FacebookMarketPlace> facebookMarketPlaceEntries = mapFacebookMarketPlaceEntries(submittedFormDto.getFacebookMarketPlace(), formularioEndOfDay);
        List<CrmProspect> crmProspects = mapCrmProspects(submittedFormDto.getCrmProspects(), formularioEndOfDay);

        formularioEndOfDay.setFacebookMarketPlaceEntries(facebookMarketPlaceEntries);
        formularioEndOfDay.setCrmProspects(crmProspects);

        return formularioEndOfDay;
    }

    @Mapping(source = "guestNameFirst", target = "guestNameFirst")
    @Mapping(source = "guestNameLast", target = "guestNameLast")
    @Mapping(source = "vehicleCondition", target = "vehicleCondition")
    @Mapping(source = "fullTank", target = "fullTank")
    @Mapping(source = "jeepWave", target = "jeepWave")
    @Mapping(source = "poddedVehicle", target = "poddedVehicle")
    @Mapping(source = "pairPhone", target = "pairPhone")
    @Mapping(source = "carplayAndroidAuto", target = "carplayAndroidAuto")
    @Mapping(source = "serviceKeyDrop", target = "serviceKeyDrop")
    @Mapping(source = "serviceWalk", target = "serviceWalk")
    @Mapping(source = "osPlusForm", target = "osPlusForm")
    @Mapping(source = "surveyExplanation", target = "surveyExplanation")
    @Mapping(source = "gdprConsent", target = "gdprConsent")
    @Mapping(source = "privacyConsent", target = "privacyConsent")
    FormularioSsi1000 toSsi1000Entity(SubmittedFormDto submittedFormDto);

    default LocalDate stringToLocalDate(String date) {
        if (null == date) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}
